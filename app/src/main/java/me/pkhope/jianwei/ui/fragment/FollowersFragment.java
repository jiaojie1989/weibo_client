package me.pkhope.jianwei.ui.fragment;

import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

import me.pkhope.jianwei.App;
import me.pkhope.jianwei.Constants;
import me.pkhope.jianwei.interfaces.Identifier;
import me.pkhope.jianwei.models.UserList;
import me.pkhope.jianwei.ui.activity.MainActivity;

/**
 * Created by pkhope on 2016/6/12.
 */
public class FollowersFragment extends FriendsFragment {

    @Override
    protected void loadMore() {
//        super.loadPage(page);
        setRefreshing(true);
        App.getWeiboAPI().follower(((Identifier)getActivity()).getIdentifier(), currentCursor++, Constants.PAGE_COUNT, new RequestListener() {
            @Override
            public void onComplete(String s) {
                setRefreshing(false);
                UserList data = UserList.parse(s);
                if (data.userList == null){
                    return;
                }
                userList.addAll(data.userList);
                adapter.notifyDataSetChanged();
//                currentCursor = Integer.parseInt(data.next_cursor);

            }

            @Override
            public void onWeiboException(WeiboException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void refreshData() {

        App.getWeiboAPI().follower(((Identifier)getActivity()).getIdentifier(), 0, Constants.PAGE_COUNT, new RequestListener() {
            @Override
            public void onComplete(String s) {
                setRefreshing(false);
                userList.clear();
                currentCursor = 1;
                UserList data = UserList.parse(s);
                if (data.userList == null){
                    return;
                }
                userList.addAll(data.userList);
                adapter.notifyDataSetChanged();
//                currentCursor = Integer.parseInt(data.next_cursor);

            }

            @Override
            public void onWeiboException(WeiboException e) {
                e.printStackTrace();
            }
        });
    }
}
