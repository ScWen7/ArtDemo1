package io.scwen7.artdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import io.scwen7.artdemo.R;
import io.scwen7.artdemo.data.CardItem;
import io.scwen7.artdemo.weight.UpRoundImageView;

import static io.scwen7.artdemo.weight.CradTranformer.MAX_ELEVATION_FACTOR;


public class CardFragment extends Fragment {

    public static final String CART_ITEM = "card_item";
    public static final String CONTENT = "content";

    private CardView mCardView;

    private UpRoundImageView iv_image;

    private TextView tv_content;

    public static CardFragment newInstance(CardItem cartItem) {
        CardFragment cardFragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CART_ITEM, cartItem);
        cardFragment.setArguments(bundle);
        return cardFragment;

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mCardView = (CardView) view.findViewById(R.id.cardView);
        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * MAX_ELEVATION_FACTOR);

        iv_image = (UpRoundImageView) view.findViewById(R.id.iv_image);
        tv_content = (TextView) view.findViewById(R.id.tv_content);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CardItem cardItem = getArguments().getParcelable(CART_ITEM);

        Glide.with(this).load(cardItem.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop().into(iv_image);

    }

    public CardView getCardView() {
        return mCardView;
    }
}
