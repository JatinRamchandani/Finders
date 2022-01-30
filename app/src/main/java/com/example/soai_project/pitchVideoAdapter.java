package com.example.soai_project;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soai_project.companydetails.Companydetail;

public class pitchVideoAdapter extends RecyclerView.Adapter<pitchVideoAdapter.pitchVideoViewHolder> {
    private List<String> vidUrls;
    private List<Companydetail> companydetails;

    public pitchVideoAdapter(List<String> vidUrls , List<Companydetail> companydetails) {
        this.vidUrls=vidUrls;
        this.companydetails=companydetails;
    }

    @NonNull
    @Override
    public pitchVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new pitchVideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_containerpitch,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull pitchVideoViewHolder holder, int position) {
       holder.setPitchdata(vidUrls.get(position),companydetails.get(position));

    }

    @Override
    public int getItemCount() {
        return vidUrls.size();
    }

    static class pitchVideoViewHolder extends RecyclerView.ViewHolder{
        VideoView pitchView;
        TextView tvcompanyname,tvcomapnylocation,tvcompanydescr;
        ProgressBar ptchprogressbar;

        public pitchVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            pitchView=itemView.findViewById(R.id.video_pith);
            tvcompanyname=itemView.findViewById(R.id.Company_nametext);
            tvcomapnylocation=itemView.findViewById(R.id.Company_loactiontext);
            tvcompanydescr=itemView.findViewById(R.id.Company_filleddestext);
            ptchprogressbar=itemView.findViewById(R.id.pitch_progressbar);

        }
        void setPitchdata(String vidUrl,Companydetail detail)
        {
            tvcompanyname.setText(detail.getCompanyName());
            tvcomapnylocation.setText(detail.getCompanyLocation());
            tvcompanydescr.setText(detail.getCompanyDesc());
            pitchView.setVideoPath(vidUrl);
            pitchView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    ptchprogressbar.setVisibility(View.GONE);
                    mediaPlayer.start();
                    float pitchRation = mediaPlayer.getVideoWidth()/ (float)mediaPlayer.getVideoHeight();
                    float ScreenRation = pitchView.getWidth()/ (float)pitchView.getHeight();
                    float scale = pitchRation/ScreenRation;
                    if(scale>=1f)
                    {
                        pitchView.setScaleX(scale);
                    }
                    else{
                        pitchView.setScaleY(1f/scale);
                    }
                }
            });
            pitchView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

        }
    }
}
