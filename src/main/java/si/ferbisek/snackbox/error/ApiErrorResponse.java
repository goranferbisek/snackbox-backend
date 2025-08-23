package si.ferbisek.snackbox.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
    private int status;
    private String message;
    private List<FieldError> fieldErrors;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class FieldError {
        private String field;
        private String message;
    }
}
