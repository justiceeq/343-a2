COPY country (cid, cname, height, population) FROM stdin;
7	China	100	178000000
8	Japan	101	23750000
9	Afganistan	102	18680000
10	Germany	103	127800000
\.

COPY neighbour (country, neighbor, length) FROM stdin;
9	10	100
10	9	101
7	8	100
8	7	101
\.

COPY ocean (oid, oname, depth) FROM stdin;
1	dead sea	178000000
2	o2	23750000
3	o3	33750000
\.

COPY hdi FROM stdin;
7	2009	95
7	2010	96
7	2011	97
7	2012	98
7	2013	99
\.

COPY language FROM stdin;
7	1	Chinese	100
7	2	Japanese	0
7	3	Shanghaiese	5
7	4	Chongqingian	5
7	5	Cantonese	4
\.


