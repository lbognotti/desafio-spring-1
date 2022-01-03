package br.com.desafio.spring.g8.desafiospring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vinicius Feitoza
 * @description Representa o formato da resposta da requisição de compra do endpoint /api/v1/purchase-request.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    /**
     * @author Vinicius Feitoza
     * @description Representa o objeto interno da resposta da requisição com o atributo "ticket".
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TicketDTO {
        public Long id;
        public List<CompleteProductDTO> articles = null;
        public double total;
    }

    public TicketDTO ticket;
}