package com.victor.secretfriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.victor.secretfriend.model.ApiResponse;
import com.victor.secretfriend.model.Player;
import com.victor.secretfriend.service.PrizeDrawService;

@RestController
public class ApiController
{

    // mapeamento post para sortear
    @PostMapping(value = "/sortear")
    public ApiResponse cadastrarAreaAtuacao(@RequestBody final List<Player> players)
    {
        System.out.println("INIT");

        String message = null;

        if(players.isEmpty())
        {
            message = "Nenhum participante informado!";

            System.out.println(message);
            System.out.println("END");
            
            return new ApiResponse(message);
        }

        if(players.size() < 3)
        {
            message = "Quantidade de participantes incoerrente para sorteio!";

            System.out.println(message);
            System.out.println("END");
            
            return new ApiResponse(message);
        }

        ApiResponse result = this.service.prizeDraw(players);

        message = "Sorteio finalizado com sucesso!";

        System.out.println(message);
        System.out.println("END");

        return result;
    }

    @Autowired
    private PrizeDrawService service;
}
