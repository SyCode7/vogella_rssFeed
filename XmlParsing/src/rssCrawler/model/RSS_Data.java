package rssCrawler.model;


public class RSS_Data {
	
	
		private Long id;
		String title;
		String link;
		String guid;
		String pubDate;
		String url;
		
		
		public RSS_Data(String title, String link, String guid, String pubDate,
				String url) {
			this.title = title;
			this.link = link;
			this.guid = guid;
			this.pubDate = pubDate;
			this.url = url;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getLink() {
			return link;
		}


		public void setLink(String link) {
			this.link = link;
		}


		public String getGuid() {
			return guid;
		}


		public void setGuid(String guid) {
			this.guid = guid;
		}


		public String getPubDate() {
			return pubDate;
		}


		public void setPubDate(String pubDate) {
			this.pubDate = pubDate;
		}


		public String getUrl() {
			return url;
		}


		public void setUrl(String url) {
			this.url = url;
		}


		@Override
		public String toString() {
			return "RSS_Data [title=" + title + ", link=" + link + ", guid="
					+ guid + ", pubDate=" + pubDate + ", url=" + url + "]";
		}
		
		
		
}

		
		
		
		
