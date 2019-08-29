package ru.turpattaya.yandextranslate.fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import ru.turpattaya.yandextranslate.DataBase.HistoryTable;
import ru.turpattaya.yandextranslate.DataBase.MySQLiteHelper;
import ru.turpattaya.yandextranslate.FavoritesAdapter;
import ru.turpattaya.yandextranslate.R;

import static ru.turpattaya.yandextranslate.DataBase.HistoryTable.COLUMN_DIRECTION_IS_FAVORITE;


public class FavoriteFragment extends Fragment {
    public FavoriteFragment() {
        // Required empty public constructor
    }

    private ListView listFavorite;
    private FavoritesAdapter adapter;
    Cursor cursor;

    public void refreshView() {
        MySQLiteHelper helper = new MySQLiteHelper(getContext());
        cursor = helper.getReadableDatabase().query(
                HistoryTable.TABLE_HISTORY, null, COLUMN_DIRECTION_IS_FAVORITE + "=1", null, null, null, null );
        adapter.changeCursor(cursor);
    }

    public interface FavoriteFragmentAddFavoriteHost {
        public void addToFavorite(int historyId,
                                  String historyTextIn,
                                  String historyTextOut,
                                  String historyTranslateDirection,
                                  int imageFavorite);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rowView = inflater.inflate(R.layout.fragment_favorite, container, false);
        listFavorite = rowView.findViewById(R.id.list_favorite);
        populateHistoryFragment();
        return rowView;
    }

    private void populateHistoryFragment() {
        MySQLiteHelper helper = new MySQLiteHelper(getContext());
        cursor = helper.getReadableDatabase().query(
                HistoryTable.TABLE_HISTORY,
                null,
                COLUMN_DIRECTION_IS_FAVORITE + "=1",
                null,
                null,
                null,
                null );
        FavoritesAdapter adapter = new FavoritesAdapter(getContext(), cursor);
        listFavorite.setAdapter(adapter);
    }
}
