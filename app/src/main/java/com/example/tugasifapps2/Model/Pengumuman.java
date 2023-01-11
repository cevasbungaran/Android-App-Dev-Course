package com.example.tugasifapps2.Model;

import java.util.List;

public class Pengumuman {
    MetaData metadata;
    List<Data> data;

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public class MetaData {
        String next;

        public String getNext() {
            return next;
        }
    }

    public class Data {
        String id;
        String title;
        String updated_at;
        String created_at;
        Author author;
        List<Tags> tags;
        String content;

        public class Author {
            String authorId;
            String authorName;

            public String getAuthorId() {
                return authorId;
            }

            public void setAuthorId(String authorId) {
                this.authorId = authorId;
            }

            public String getAuthorName() {
                return authorName;
            }

            public void setAuthorName(String authorName) {
                this.authorName = authorName;
            }
        }

        public class Tags {
            String tag;
            String tag_id;
            String id;

            public Tags(String tag, String tag_id, String id) {
                this.tag = tag;
                this.tag_id = tag_id;
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public String getTagName() {
                return tag;
            }

            public void setTagName(String tagName) {
                this.tag = tagName;
            }

            public String getTagId() {
                return tag_id;
            }

            public void setTagId(String tagId) {
                this.tag_id = tagId;
            }
        }

        public String getContent() {
            return content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public List<Tags> getTags() {
            return tags;
        }

        public void setTags(List<Tags> tags) {
            this.tags = tags;
        }
    }
}


