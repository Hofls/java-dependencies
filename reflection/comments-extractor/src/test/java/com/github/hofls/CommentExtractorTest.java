package com.github.hofls;

import com.github.hofls.entity.Product;
import org.junit.jupiter.api.Test;

class CommentExtractorTest {

    @Test
    void printComments() {
        var entity = CommentExtractor.readFromSource(Product.class);
        entity.fields().forEach(f -> {
            System.out.println(f.comment());
            System.out.println();
        });
    }

}
