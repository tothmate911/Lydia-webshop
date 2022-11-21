# FROM node:14-alpine
# WORKDIR /app
# COPY package.json ./
# # RUN npm cache clean --force
# RUN npm install --no-package-lock
# COPY ./ ./
# EXPOSE 3000
# CMD ["npm", "start"]




# The above lines constitute a workable solution
# But using nginx base image reduces significantly the needed resources to run the image
# So it is better to use it if you want to deploy the image with limited resources
FROM node:alpine as react_build
WORKDIR /app
#copy the react app to the container
COPY . /app/ 
#prepare the contiainer for building react 
RUN npm install --silent
RUN npm install react-scripts@3.0.1 -g --silent 
RUN npm run build 

#prepare nginx
FROM nginx:1.16.0-alpine
COPY --from=react_build /app/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx/nginx.conf /etc/nginx/conf.d

# Default port exposure
EXPOSE 80

# Copy .env file and shell script to container
WORKDIR /usr/share/nginx/html
COPY ./env.sh .
COPY .env .

# Make our shell script executable
RUN chmod +x env.sh

# Start Nginx server
CMD ["/bin/sh", "-c", "/usr/share/nginx/html/env.sh && nginx -g \"daemon off;\""]
