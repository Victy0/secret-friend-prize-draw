package com.victor.secretfriend.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java. util. Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.secretfriend.model.ApiResponse;
import com.victor.secretfriend.model.Player;

@Service
public class PrizeDrawService
{
    // método para realizar o sorteio
    public ApiResponse prizeDraw(List<Player> playerList)
    {
        int index = 0;
        List<Integer> alreadyDrawn = new ArrayList<Integer>();
        List<Player> auxPlayerList = new ArrayList<Player>(playerList);
        
        for (Player player : playerList)
        {
            if(alreadyDrawn.size() == playerList.size() - 1)
            {
                Player auxPlayer = auxPlayerList.get(0);
                
                if(player.equals(auxPlayer))
                {
                    Random random = new Random();
                    
                    Player drawnPlayer = playerList.get(random.nextInt(playerList.size() - 1));
                    
                    player.setSecretFriend(drawnPlayer.getSecretFriend());
                    drawnPlayer.setSecretFriend(auxPlayer);
    
                    continue;
                }
                
                player.setSecretFriend(auxPlayer);
                continue;
            }
            
            index = this.getIndex(playerList.indexOf(player), playerList.size(), alreadyDrawn);
            alreadyDrawn.add(index);
            auxPlayerList.remove(playerList.get(index));
            
            player.setSecretFriend(playerList.get(index));
        }

        this.sendEmailToPlayers(playerList);
        
        return new ApiResponse();
    }

    private int getIndex(int indexPlayerInList, int maxIndex, List<Integer> alreadyDrawn)
    {
        
        Random random = new Random();
        int index = random.nextInt(maxIndex);
        
        if(index == indexPlayerInList)
        {
            return getIndex(indexPlayerInList, maxIndex, alreadyDrawn);
        }
        else if (alreadyDrawn.contains(index))
        {
            return getIndex(indexPlayerInList, maxIndex, alreadyDrawn);
        }
        
        return index;
    }

    private void sendEmailToPlayers(List<Player> playerList)
    {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = calendar.getTime();

        String date = format.format(data);

        for (Player player : playerList)
        {
            String title = "AMIGO OCULTO - Sorteio do dia " +  date;

            String body = "Olá, " + player.getName() + "\n\nVocê tirou como amigo oculto: " + player.getSecretFriend().getName() + "\n\nAgradecido pela visualização!";

            this.emailService.sendEmail(player.getEmail(), title, body);

            System.out.println("Enviado e-mail para: " + player.getName() + " - " + player.getEmail());
        }
    }

    @Autowired
    private EmailService emailService;
}
