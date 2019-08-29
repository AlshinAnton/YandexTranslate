package ru.turpattaya.yandextranslate;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MSI on 4/10/2017.
 */

public class ViewHolderItem {

        ImageView imageFavoriteIcon;
        TextView textInHistory;
        TextView textOutHistory;
        TextView textTranslationDirectionHistory;

        boolean isFavorite;

        public int id ;

        HistoryAdapter parentAdapter;
}
