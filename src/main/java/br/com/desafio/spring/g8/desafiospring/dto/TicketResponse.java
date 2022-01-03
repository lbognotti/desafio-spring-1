package br.com.desafio.spring.g8.desafiospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TicketDTO{
        public Long id;
        @JsonProperty("articles")
        public List<CompleteProductDTO> articles = null;
        public double total;
    }
    public TicketDTO ticket;
}