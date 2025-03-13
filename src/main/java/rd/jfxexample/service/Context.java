package rd.jfxexample.service;

public class Context {

    private DocumentService documentService;

    public void populate() {
        if (documentService == null)
            documentService = new DocumentService(this);
    }

}
