/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License (the "License").
 * You may not use this file except in compliance with the License.
 *
 * See LICENSE.txt included in this distribution for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at LICENSE.txt.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information: Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 */

/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 * Portions Copyright (c) 2023, Maxim Grankin <mgrankin@bloomberg.net>.
 */
package org.opengrok.indexer.analysis.ocaml;

import org.opengrok.indexer.analysis.AbstractAnalyzer;
import org.opengrok.indexer.analysis.AnalyzerFactory;
import org.opengrok.indexer.analysis.JFlexTokenizer;
import org.opengrok.indexer.analysis.JFlexXref;
import org.opengrok.indexer.analysis.plain.AbstractSourceCodeAnalyzer;

import java.io.Reader;

/**
 *
 * @author Maxim Grankin
 */
public class OCamlAnalyzer extends AbstractSourceCodeAnalyzer  {
    /**
     * Creates a new instance of OCamlAnalyzer.
     *
     * @param factory                defined instance for the analyzer
     */
    protected OCamlAnalyzer(final AnalyzerFactory factory) {
        super(factory, () -> JFlexTokenizer(new OCamlSymbolTokenizer(AbstractAnalyzer.DUMMY_READER)));
    }

    @Override
    protected JFlexXref newXref(final Reader reader) {
        return new JFlexXref(new OCamlXref(reader));
    }
}