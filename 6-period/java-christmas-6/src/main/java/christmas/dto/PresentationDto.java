package christmas.dto;

import christmas.model.Presentation;

public record PresentationDto(int count) {
    public PresentationDto(Presentation presentation) {
        this(presentation.getCount());
    }
}
