package uz.uzrailways.domain.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KadrResponse
{
    private boolean status;
    private String message;
    private Object object;
}
