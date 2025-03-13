package rd.jfxexample.service;

import rd.jfxexample.model.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentService {
    private final Context context;
    private final List<Document> documentList = new ArrayList<>();

    public DocumentService(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }
}
