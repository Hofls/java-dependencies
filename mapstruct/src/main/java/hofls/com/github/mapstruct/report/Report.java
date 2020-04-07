package hofls.com.github.mapstruct.report;

import lombok.Data;

@Data
public class Report {

    private HeaderSettings headerSettings;
    private FooterSettings footerSettings;

    @Data
    public static class HeaderSettings {
        private boolean showLogo;
    }

    @Data
    public static class FooterSettings {
        private boolean showPageNumber;
    }

}
