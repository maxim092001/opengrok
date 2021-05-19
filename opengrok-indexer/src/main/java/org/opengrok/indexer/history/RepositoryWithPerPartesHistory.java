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
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
 */
package org.opengrok.indexer.history;

import java.io.File;

/**
 * Repositories extending this class will benefit from per partes history
 * indexing which saves memory.
 */
public abstract class RepositoryWithPerPartesHistory extends Repository {
    private static final long serialVersionUID = -3433255821312805064L;
    public static final int MAX_CHANGESETS = 128;

    /**
     * Just like for {@link Repository#getHistory(File)} it is expected that the lists of (renamed) files
     * individual files (i.e. not directory) are empty.
     * @param file file to retrieve history for
     * @param sinceRevision start revision (non inclusive)
     * @param tillRevision end revision (inclusive)
     * @return history object
     * @throws HistoryException if history retrieval fails
     */
    abstract History getHistory(File file, String sinceRevision, String tillRevision) throws HistoryException;

    /**
     * @return maximum number of entries to retrieve
     */
    public int getPerPartesCount() {
        return MAX_CHANGESETS;
    }

    /**
     * Traverse the changesets using the visitor pattern.
     * @param sinceRevision start revision
     * @param visitor object implementing the {@link ChangesetVisitorInterface} interface
     * @throws HistoryException on error during history retrieval
     */
    public abstract void accept(String sinceRevision, ChangesetVisitorInterface visitor) throws HistoryException;
}
