
CREATE TABLE `parent_task` (
  `parent_id` int(10) NOT NULL,
  `parent_task` varchar(500) NOT NULL
);

CREATE TABLE `task` (
  `task_id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `task` varchar(500) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `priority` int(11) NOT NULL,
  `in_progress` boolean NOT NULL
) ;

ALTER TABLE `parent_task`
  ADD PRIMARY KEY (`parent_id`);


ALTER TABLE `task`
  ADD PRIMARY KEY (`task_id`),
  ADD KEY `task_fk` (`parent_id`);

ALTER TABLE `task`
  MODIFY `task_id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `task`
  ADD CONSTRAINT `task_fk` FOREIGN KEY (`parent_id`) REFERENCES `parent_task` (`parent_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

INSERT INTO `parent_task` (`parent_id`, `parent_task`) VALUES
(1, 'Parent_1'),
(2, 'Parent_2'),
(3, 'Parent_3')
);
