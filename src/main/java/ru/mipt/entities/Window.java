package ru.mipt.entities;

import lombok.Data;
import ru.mipt.entities.Node;

@Data
public class Window {
    private final Node grandParent;
    private final Node parent;
    private final Node current;
}
