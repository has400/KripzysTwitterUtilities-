package DownloadKeys;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import twitter4j.Twitter;

public class DownloadKeys {

	public JFrame frame;

	static Twitter twitter;

	static ArrayList<Long> DeniedTweets;
	static String filename = "config.txt";

	static String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "KripTech"
			+ File.separator + "TwitterContestBot";

	static String ConsumerKey = null;
	static String ConsumerSecret = null;
	static String AccessToken = null;
	static String AccessSecret = null;

	static ArrayList<Long> idsOfNotDelete = new ArrayList<Long>();

	public static void main(String[] args) {
		if (args.length == 1) {
			load(args[0]);
			startBotUnFollow();
		} else {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DownloadKeys window = new DownloadKeys();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	}

	static String inputOfButton;

	private static void load(String input2) {
		getNewKeys(input2);

	}

	private static void getNewKeys(String bot) {
		String[] keys = getBot(bot.toLowerCase(), "kripzy", 3245);

		Writer wr;
		try {
			wr = new FileWriter(path + File.separator + bot.toLowerCase() + File.separator + filename);

			wr.write(keys[0]);
			wr.write(System.getProperty("line.separator"));
			wr.write(keys[1]);
			wr.write(System.getProperty("line.separator"));
			wr.write(keys[2]);
			wr.write(System.getProperty("line.separator"));
			wr.write(keys[3]);

			wr.flush();
			wr.close();

		} catch (IOException e1) {
		}
	}
	
	private static String[] getBot(String bot, String botid, int PW) {
		String https_url = "https://kripzy.com/getbot.php?botid=" + botid + bot + "&PW=" + PW;

		URL url;

		try {

			url = new URL(https_url);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			// dump all the content
			return getBotText(con);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String[] getBotText(HttpsURLConnection con) {
		if (con != null) {

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				String input;
				while ((input = br.readLine()) != null) {
					String[] keys = input.split("<br>");
					return keys;
				}
				br.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	static List<Long> longIDList = new ArrayList<Long>();

	private static void startBotUnFollow() {
		System.out.println("Done.");
	}

	public DownloadKeys() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {

		frame = new JFrame();
		frame.setBounds(100, 100, 415, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("KripTech - Unfollow Users");
		frame.getContentPane().setLayout(null);

		JButton btnNewButton_1 = new JButton("Bot1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						load(btnNewButton_1.getText());
						startBotUnFollow();
					}
				}.start();

			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton = new JButton("Bot2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(btnNewButton.getText());
						startBotUnFollow();
					}
				}.start();

			}
		});
		btnNewButton.setBounds(10, 45, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Bot3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(btnNewButton_2.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		btnNewButton_2.setBounds(10, 79, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Bot4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						load(btnNewButton_3.getText());
						startBotUnFollow();
					}
				}.start();

			}
		});
		btnNewButton_3.setBounds(10, 113, 89, 23);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Bot6");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						load(btnNewButton_4.getText());
						startBotUnFollow();
					}
				}.start();
			}
		});
		btnNewButton_4.setBounds(109, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnBot = new JButton("Bot5");
		btnBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(btnBot.getText());
						startBotUnFollow();

					}
				}.start();
			}
		});
		btnBot.setBounds(10, 147, 89, 23);
		frame.getContentPane().add(btnBot);

		JButton btnNewButton_5 = new JButton("Bot7");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(btnNewButton_5.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		btnNewButton_5.setBounds(109, 45, 89, 23);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Bot8");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(btnNewButton_6.getText());
						startBotUnFollow();

					}
				}.start();
			}
		});
		btnNewButton_6.setBounds(109, 79, 89, 23);
		frame.getContentPane().add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Bot9");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(btnNewButton_7.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		btnNewButton_7.setBounds(109, 113, 89, 23);
		frame.getContentPane().add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Bot10");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(btnNewButton_8.getText());
						startBotUnFollow();

					}
				}.start();
			}
		});
		btnNewButton_8.setBounds(109, 147, 89, 23);
		frame.getContentPane().add(btnNewButton_8);

		JButton button = new JButton("Bot11");
		button.setBounds(208, 11, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("Bot12");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_1.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_1.setBounds(208, 45, 89, 23);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("Bot13");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_2.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_2.setBounds(208, 79, 89, 23);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("Bot14");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_3.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_3.setBounds(208, 113, 89, 23);
		frame.getContentPane().add(button_3);

		JButton button_4 = new JButton("Bot15");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_4.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_4.setBounds(208, 147, 89, 23);
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("Bot16");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_5.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_5.setBounds(307, 11, 89, 23);
		frame.getContentPane().add(button_5);

		JButton button_6 = new JButton("Bot17");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_6.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_6.setBounds(307, 45, 89, 23);
		frame.getContentPane().add(button_6);

		JButton button_7 = new JButton("Bot18");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_7.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_7.setBounds(307, 79, 89, 23);
		frame.getContentPane().add(button_7);

		JButton button_8 = new JButton("Bot19");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_8.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_8.setBounds(307, 113, 89, 23);
		frame.getContentPane().add(button_8);

		JButton button_9 = new JButton("Bot20");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {

						load(button_9.getText());
						startBotUnFollow();

					}
				}.start();

			}
		});
		button_9.setBounds(307, 147, 89, 23);
		frame.getContentPane().add(button_9);

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/images/KripzySketch2.png"));
		Image image = imageIcon.getImage(); // transform it
		imageIcon = new ImageIcon(image);

		frame.setResizable(false);
	}
	
}
