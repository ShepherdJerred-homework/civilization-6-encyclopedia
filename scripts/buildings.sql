-- t1 = Buildings
-- t2 = EnglishText
--
-- trans_id = Tag
-- id = Name
-- status = Text

UPDATE Buildings
           SET Name = (SELECT t2.Text FROM EnglishText t2 WHERE t2.Tag = Name),
               name = (SELECT t2.Text FROM EnglishText t2 WHERE t2.Tag = Name)
           WHERE Name IN (SELECT Tag FROM EnglishText t2 WHERE t2.Tag= Name)