import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Request } from '../../class/request';
import { DataPipelineService } from '../../service/data-pipeline.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-request-form',
  templateUrl: './request-form.component.html',
  styleUrls: ['./request-form.component.css']
})
export class RequestFormComponent implements OnInit {
  requestForm: FormGroup;
  types: Object= {
    'University Course': 1,
    'Seminar': 2,
    'Certification Prep': 3,
    'Certification': 4,
    'Technical Training': 5,
    'Other': 6
  };
  g_formats: Object= {
    'Presentation': 1,
    'Grades': 2
  };
  constructor(private formBuilder: FormBuilder, private ds: DataPipelineService, private router: Router) {}

  ngOnInit() {
    this.requestForm = this.formBuilder.group({
      event: this.formBuilder.group({
        name: ['', Validators.required],
        st_address: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        zip: ['', Validators.required],
        date: ['', Validators.required],
        time: ['', Validators.required],
        work_time_missed: ['', Validators.required],
        g_format: ['']
      }),
      type: ['', Validators.required],
      cost: ['', Validators.required],
      description: ['', Validators.required],
      justification: ['', Validators.required]
    });
  }
  objectKeys(obj) {
    return Object.keys(obj);
  }

  onSubmit(f) {
    let form = f.value;
    let submit: Request = {
      event: {
        name: form.event.name,
        location: form.event.st_address + ' ' + form.event.city + ' ' + form.event.state + ' ' + form.event.zip,
        datetime: new Date(Date.parse(form.event.date + ':' + form.event.time)),
        work_time_loss: form.event.work_time_missed,
        g_format_id: this.g_formats[form.event.g_format]
      },
      cost: form.cost,
      type: this.types[form.type],
      description: form.description,
      justification: form.justification,
    };
    this.ds.postData(submit).subscribe((res)=>console.log(res));
    this.router.navigate(['/user']);
  }

}
