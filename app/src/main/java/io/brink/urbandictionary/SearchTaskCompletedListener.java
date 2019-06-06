package io.brink.urbandictionary;

import java.util.List;

public interface SearchTaskCompletedListener {
    void onSearchTaskCompleted(String[] defnList);
}
