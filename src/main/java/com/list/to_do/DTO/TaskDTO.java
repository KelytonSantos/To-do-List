package com.list.to_do.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;

public record TaskDTO(@NotBlank String taskName, @NotNull String taskDescription, Instant validityTime,
                @NotBlank String priorityTask) {
}
