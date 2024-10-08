package com.example.uniquindio.spring.model.vo.items;

import com.example.uniquindio.spring.model.documents.Event;
import lombok.*;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter

public class Ticket {
    @NonNull
    private Event evento;
    @NonNull
    private Locality locality;

}
