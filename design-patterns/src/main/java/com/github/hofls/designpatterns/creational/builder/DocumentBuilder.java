package com.github.hofls.designpatterns.creational.builder;

public class DocumentBuilder {

    private final DocumentParts.Document document;

    public DocumentBuilder() {
        this.document = new DocumentParts.Document();
    }

    public DocumentBuilder addHeader(DocumentParts.Element element) {
        document.add(element);
        return this;
    }

    public DocumentBuilder addBody(DocumentParts.Element element) {
        document.add(element);
        return this;
    }

    public DocumentBuilder addFooter(DocumentParts.Element element) {
        document.add(element);
        return this;
    }

    public DocumentParts.Document build() {
        return document;
    }

}
