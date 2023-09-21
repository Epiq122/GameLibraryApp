import {Injectable} from '@angular/core';
import axios from 'axios';


@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  constructor() {
    axios.defaults.baseURL = "http://localhost8080/api"
    axios.defaults.headers.post["Content-type"] = "application/json"
  }

  request(method: string, url: string): Promise<any> {
    return axios({
      method: method,
      url: url,
      data: data,
    })
  }
}
