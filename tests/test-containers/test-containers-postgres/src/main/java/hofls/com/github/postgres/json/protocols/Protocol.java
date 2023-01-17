package hofls.com.github.postgres.json.protocols;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Protocol {
    SMTP("Simple Mail Transfer Protocol"),
    FTP("File Transfer Protocol");

    private final String description;
}
