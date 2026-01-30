 void display(void)
 {
 point2 vertices[3] = {{0.0,0.0}, {250.0,500}, {500.0, 0.0}};
 static point2 p={75.0, 50.0};
 int j,k;
 for(k=0; k<5000;k++)
 {
 j=rand()%3;
 p[0]=(p[0]+triangle[j][0])/2;
 p[1]=(p[1]+triangle[j][1])/2;
 glBegin(GLPOINTS);
 glVertex2fv(p);
 glEnd();
 }
 glFlush();
 }