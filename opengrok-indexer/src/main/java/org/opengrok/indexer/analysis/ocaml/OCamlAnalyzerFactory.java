package org.opengrok.indexer.analysis.ocaml;

import org.opengrok.indexer.analysis.AbstractAnalyzer;
import org.opengrok.indexer.analysis.FileAnalyzerFactory;

public class OCamlAnalyzerFactory extends FileAnalyzerFactory {
    private static final String NAME = "OCaml";


    private static final String[] SUFFIXES = {
            "ML",
            "MLI",
    };

    public OCamlAnalyzerFactory() {
        super(null, null, SUFFIXES, null, null, "text/plain", AbstractAnalyzer.Genre.PLAIN, NAME);
    }

    @Override
    protected AbstractAnalyzer newAnalyzer() {
        return new OCamlAnalyzer(this);
    }
}
