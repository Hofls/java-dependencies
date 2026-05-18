package hofls.com.github.postgres.json.parameters;

import hofls.com.github.postgres.json.KanbanCard;
import lombok.experimental.UtilityClass;

import java.util.LinkedHashMap;

@UtilityClass
public class ParametersUtils {

    public static IParameters extractParameters(KanbanCard card) {
        if (card.getCardType() == null) return null;
        
        if (card.getCardType().equals(KanbanCard.CardType.TYPE_A)) {
            return ObjectMapperUtils.toObject(card.getParameters(), ParametersA.class);
        } else if (card.getCardType().equals(KanbanCard.CardType.TYPE_B)) {
            return ObjectMapperUtils.toObject(card.getParameters(), ParametersB.class);
        }
        return null;
    }

}
