package ru.turpattaya.yandextranslate;

import android.content.Context;
import android.database.Cursor;

import ru.turpattaya.yandextranslate.DataBase.HistoryTable;
import ru.turpattaya.yandextranslate.DataBase.MySQLiteHelper;

import static ru.turpattaya.yandextranslate.DataBase.HistoryTable.COLUMN_DIRECTION_IS_FAVORITE;


public class FavoritesAdapter extends HistoryAdapter {

    public FavoritesAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    Cursor updateDBCursor(MySQLiteHelper helper)
    {
        return helper.getReadableDatabase().query(
                HistoryTable.TABLE_HISTORY,
                null,
                COLUMN_DIRECTION_IS_FAVORITE + "=1",
                null,
                null,
                null,
                null );
    }
}
