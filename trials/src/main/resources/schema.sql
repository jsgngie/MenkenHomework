CREATE TABLE Document (
                                 id SERIAL PRIMARY KEY,
                                 document_type VARCHAR(255) NOT NULL, -- Document name
                                 weight DECIMAL(21, 20) NOT NULL -- Document weight
);

INSERT INTO Document (document_type, weight) VALUES ('Curriculum Vitae', 2.6372483412450085e-05);
