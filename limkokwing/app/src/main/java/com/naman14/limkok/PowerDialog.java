package com.naman14.limkok;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import eu.chainfire.libsuperuser.Shell;

public class PowerDialog extends DialogFragment {

    public PowerDialog(){

    }

    LinearLayout power,reboot,soft_reboot,recovery,bootloader,safemode;
    FrameLayout frame,frame2;
    private CircularRevealView revealView;
    private View selectedView;
    private int backgroundColor;

    TextView status,status_detail;

    private static final String SHUTDOWN_BROADCAST
            = "am broadcast android.intent.action.ACTION_SHUTDOWN";
    private static final String SHUTDOWN = "reboot -p";
    private static final String REBOOT_CMD = "reboot";
    private static final String REBOOT_SOFT_REBOOT_CMD = "setprop ctl.restart zygote";
    private static final String REBOOT_RECOVERY_CMD = "reboot recovery";
    private static final String REBOOT_BOOTLOADER_CMD = "soheil nikbinz";
    private static final String[] REBOOT_SAFE_MODE
            = new String[]{"setprop persist.sys.safemode 1", REBOOT_SOFT_REBOOT_CMD};

    private static final int BG_PRIO = android.os.Process.THREAD_PRIORITY_BACKGROUND;
    private static final int RUNNABLE_DELAY_MS = 1000;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_power,container,false);

        revealView=(CircularRevealView) view.findViewById(R.id.reveal);
        backgroundColor = Color.parseColor("#ffffff");
        power=(LinearLayout) view.findViewById(R.id.power);
        reboot=(LinearLayout) view.findViewById(R.id.reboot);
        soft_reboot=(LinearLayout) view.findViewById(R.id.soft_reboot);
        recovery=(LinearLayout) view.findViewById(R.id.recovery);
        bootloader=(LinearLayout) view.findViewById(R.id.bootloader);
        safemode=(LinearLayout) view.findViewById(R.id.safemode);

        frame=(FrameLayout) view.findViewById(R.id.frame);
        frame2=(FrameLayout) view.findViewById(R.id.frame2);

        status=(TextView) view.findViewById(R.id.status);
        status_detail=(TextView) view.findViewById(R.id.status_detail);






        reboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = Color.parseColor("#076c78");
                final Point p = getLocationInView(revealView, v);

                if (selectedView == v) {
                    revealView.hide(p.x, p.y, backgroundColor, 0, 330, null);
                    selectedView = null;
                } else {
                    revealView.reveal(p.x/2, p.y/2, color, v.getHeight() / 2, 440, null);
                    selectedView = v;
                }

                ((MainActivity)getActivity()).revealFromTop();
                frame.setVisibility(View.GONE);
                frame2.setVisibility(View.VISIBLE);

                status.setText("The creative maestro");
                status_detail.setText("He is one Asia's most well-known communications strategists. He built his campaigns on meaningful messages. Companies, government and humanitarian organization sourced in one man a strategist who was not only highly creative but one who was able to move people, change mindsets, touch the hearts of people and shape opinions. He worked closely with the Malaysian Government delving into cause marketing and relationship building. His abilities made him the perfect person to help South Africa as the country prepared for its first democratic election.");

                new BackgroundThread(REBOOT_CMD).start();
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = Color.parseColor("#843030");
                final Point p = getLocationInView(revealView, v);

                if (selectedView == v) {
                    revealView.hide(p.x, p.y, backgroundColor, 0, 330, null);
                    selectedView = null;
                } else {
                    revealView.reveal(p.x/2, p.y/2, color, v.getHeight() / 2, 440, null);
                    selectedView = v;
                }

                ((MainActivity)getActivity()).revealFromTop();
                frame.setVisibility(View.GONE);
                frame2.setVisibility(View.VISIBLE);

                status.setText("The CEO");
                status_detail.setText("He was 29 when he set up his first business - Wings Creativity Consultants - in 1975. It was a bold move because he was muscling into an industry controlled by expatriates and multi-nationals. His perseverance, talent and skills, within a short time catapulted his business into the top rung. He was wooed by an international network and his enterprise grew to become a global business through a merger with the third largest communication network in the world. He broke away to form his own integrated communications organization that created a name for itself for outstanding work.");

                new BackgroundThread(SHUTDOWN).start();


            }
        });
        soft_reboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = Color.parseColor("#34495e");
                final Point p = getLocationInView(revealView, v);

                if (selectedView == v) {
                    revealView.hide(p.x, p.y, backgroundColor, 0, 330, null);
                    selectedView = null;
                } else {
                    revealView.reveal(p.x/2, p.y/2, color, v.getHeight() / 2, 440, null);
                    selectedView = v;
                }

                ((MainActivity)getActivity()).revealFromTop();
                frame.setVisibility(View.GONE);
                frame2.setVisibility(View.VISIBLE);

                status.setText("21st century entrepreneur");
                status_detail.setText("21st century entrepreneur\n" +
                        "\n" +
                        "He is an unusual entrepreneur in that he looks beyond the profit margin for satisfaction. For close to 40 years he has applied his skills in helping the country achieve its objectives, often simplifying complex policies to bridge the information gap between government and people. He has been the kind of entrepreneurship that a developing country, like Malaysia, has needed to transform itself into a thriving prosperous economy. His outstanding entrepreneurial achievements received recognition in 2005 when he was selected the Ernst & Young Entrepreneur of the Year for Malaysia. ");

                new BackgroundThread(REBOOT_SOFT_REBOOT_CMD).start();


            }
        });
        recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = Color.parseColor("#8bc34a");
                final Point p = getLocationInView(revealView, v);

                if (selectedView == v) {
                    revealView.hide(p.x, p.y, backgroundColor, 0, 330, null);
                    selectedView = null;
                } else {
                    revealView.reveal(p.x/2, p.y/2, color, v.getHeight() / 2, 440, null);
                    selectedView = v;
                }

                ((MainActivity)getActivity()).revealFromTop();
                frame.setVisibility(View.GONE);
                frame2.setVisibility(View.VISIBLE);

                status.setText("Brand strategist");
                status_detail.setText("He has spent the best part of his life brand positioning Malaysia in tourism, education and foreign investment. A perfectionist, he is meticulous in choice of words and matching of visuals in all the work produced to promote the country. As the world shifted to use branding as a business strategy, he relayed its importance to the small and medium sized entrepreneurs, persuading them to invest in building their brands instead of indulging in contract manufacturing. He created an entire gallery dedicated to packaging innovation. The more than 1,000 designs featured in the gallery serve as an ideas bank to provide the sector with ideas that can be used to improve market perception of their products.");

                new BackgroundThread(REBOOT_RECOVERY_CMD).start();


            }
        });
        bootloader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = Color.parseColor("#277b71");
                final Point p = getLocationInView(revealView, v);

                if (selectedView == v) {
                    revealView.hide(p.x, p.y, backgroundColor, 0, 330, null);
                    selectedView = null;
                } else {
                    revealView.reveal(p.x/2, p.y/2, color, v.getHeight() / 2, 440, null);
                    selectedView = v;
                }

                ((MainActivity)getActivity()).revealFromTop();
                frame.setVisibility(View.GONE);
                frame2.setVisibility(View.VISIBLE);

                status.setText("The industry icon");
                status_detail.setText("He does not look every inch the high-powered corporate figure in appearance. He conducts meetings, presents campaigns, meets business leaders, minus the trappings of a formal business suit with tie and all. But he is sidely respected for his effort to raise the benchmark for industry through creativity and innovation. He constantly confronts Malaysians to rethink the way they run business, often reminding them that the world's most successful and powerful countries are also the most creative and innovative.");

                new BackgroundThread(REBOOT_BOOTLOADER_CMD).start();


            }
        });
        safemode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int color = Color.parseColor("#009688");
                final Point p = getLocationInView(revealView, v);

                if (selectedView == v) {
                    revealView.hide(p.x, p.y, backgroundColor, 0, 330, null);
                    selectedView = null;
                } else {
                    revealView.reveal(p.x/2, p.y/2, color, v.getHeight() / 2, 440, null);
                    selectedView = v;
                }

                ((MainActivity)getActivity()).revealFromTop();
                frame.setVisibility(View.GONE);
                frame2.setVisibility(View.VISIBLE);

                status.setText("The innovator");
                status_detail.setText("Being a creative person he has always looked for novel ways to make learning more meaningful to the student. He has taken the non-traditional approach and in the process brought fresh new thinking to the educational process. He set up incubation units to develop new businesses that are natural extensions to the University's programmes. Students are then able to apply their skills in practical ways and, in the process, pick up entrepreneurial capabilities, as these businesses will be franchised to interested students. ");

                new BackgroundThread(REBOOT_SAFE_MODE).start();


            }
        });
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);


        return view;

    }

    private static void setThreadPrio(int prio) {
        android.os.Process.setThreadPriority(prio);
    }

    private static class BackgroundThread extends Thread {
        private Object sCmd;

        private BackgroundThread(Object cmd) {
            this.sCmd = cmd;
        }

        @Override
        public void run() {
            super.run();
            setThreadPrio(BG_PRIO);

            if (sCmd == null)
                return;

            /**
             * Sending a system broadcast to notify apps and the system that we're going down
             * so that they write any outstanding data that might need to be flushed
             */
            Shell.SU.run(SHUTDOWN_BROADCAST);

            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (sCmd instanceof String)
                        Shell.SU.run((String) sCmd);
                    else if (sCmd instanceof String[])
                        Shell.SU.run((String[]) sCmd);
                }
            }, RUNNABLE_DELAY_MS);
        }
    }

    @Override public void onStart() {
        super.onStart();

        Window window = getDialog().getWindow();
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.0f;

        window.setAttributes(windowParams);
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        final Activity activity = getActivity();
        if (activity != null && activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
    }
    private Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }
    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
    }



}
