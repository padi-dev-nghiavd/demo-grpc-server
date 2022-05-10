package user;

import com.paditech.grpc.User.APIResponse;
import com.paditech.grpc.User.Empty;
import com.paditech.grpc.User.LoginRequest;
import com.paditech.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("inside login");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			response.setResponseCode(0).setResponsemessage("SUCCESS");
		}else {
			response.setResponseCode(100).setResponsemessage("INVALID PASSWORD");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}

}
