package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class IdentificationSuccessMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 22;
    private boolean _isInitialized = false;
    private String login = "";
    private String nickname = "";
    private int accountId = 0;
    private int communityId = 0;
    private boolean hasRights = false;
    private String secretQuestion = "";
    private Number accountCreation = 0;
    private Number subscriptionElapsedDuration = 0;
    private Number subscriptionEndDate = 0;
    private boolean wasAlreadyConnected = false;
    private int havenbagAvailableRoom = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 22;
    }

    public IdentificationSuccessMessage initIdentificationSuccessMessage(String param1,String  param2,int  param3,int  param4,boolean  param5,String  param6,Number  param7,Number  param8,Number  param9,boolean  param10,int  param11) {
         this.login = param1;
         this.nickname = param2;
         this.accountId = param3;
         this.communityId = param4;
         this.hasRights = param5;
         this.secretQuestion = param6;
         this.accountCreation = param7;
         this.subscriptionElapsedDuration = param8;
         this.subscriptionEndDate = param9;
         this.wasAlreadyConnected = param10;
         this.havenbagAvailableRoom = param11;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.login = "";
         this.nickname = "";
         this.accountId = 0;
         this.communityId = 0;
         this.hasRights = false;
         this.secretQuestion = "";
         this.accountCreation = 0;
         this.subscriptionElapsedDuration = 0;
         this.subscriptionEndDate = 0;
         this.wasAlreadyConnected = false;
         this.havenbagAvailableRoom = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_IdentificationSuccessMessage(param1);
    }

    public void serializeAs_IdentificationSuccessMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.hasRights);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.wasAlreadyConnected);
         param1.writeByte(_loc2_);
         param1.writeUTF(this.login);
         param1.writeUTF(this.nickname);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         if(this.communityId < 0)
         {
            throw new Exception("Forbidden value (" + this.communityId + ") on element communityId.");
         }
         param1.writeByte(this.communityId);
         param1.writeUTF(this.secretQuestion);
         if(this.accountCreation < 0 || this.accountCreation > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.accountCreation + ") on element accountCreation.");
         }
         param1.writeDouble(this.accountCreation);
         if(this.subscriptionElapsedDuration < 0 || this.subscriptionElapsedDuration > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionElapsedDuration + ") on element subscriptionElapsedDuration.");
         }
         param1.writeDouble(this.subscriptionElapsedDuration);
         if(this.subscriptionEndDate < 0 || this.subscriptionEndDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionEndDate + ") on element subscriptionEndDate.");
         }
         param1.writeDouble(this.subscriptionEndDate);
         if(this.havenbagAvailableRoom < 0 || this.havenbagAvailableRoom > 255)
         {
            throw new Exception("Forbidden value (" + this.havenbagAvailableRoom + ") on element havenbagAvailableRoom.");
         }
         param1.writeByte(this.havenbagAvailableRoom);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationSuccessMessage(param1);
    }

    public void deserializeAs_IdentificationSuccessMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._loginFunc(param1);
         this._nicknameFunc(param1);
         this._accountIdFunc(param1);
         this._communityIdFunc(param1);
         this._secretQuestionFunc(param1);
         this._accountCreationFunc(param1);
         this._subscriptionElapsedDurationFunc(param1);
         this._subscriptionEndDateFunc(param1);
         this._havenbagAvailableRoomFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdentificationSuccessMessage(param1);
    }

    public void deserializeAsyncAs_IdentificationSuccessMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._loginFunc);
         param1.addChild(this._nicknameFunc);
         param1.addChild(this._accountIdFunc);
         param1.addChild(this._communityIdFunc);
         param1.addChild(this._secretQuestionFunc);
         param1.addChild(this._accountCreationFunc);
         param1.addChild(this._subscriptionElapsedDurationFunc);
         param1.addChild(this._subscriptionEndDateFunc);
         param1.addChild(this._havenbagAvailableRoomFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.hasRights = BooleanByteWrapper.getFlag(_loc2_,0);
         this.wasAlreadyConnected = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _loginFunc(ICustomDataInput param1) {
         this.login = param1.readUTF();
    }

    private void _nicknameFunc(ICustomDataInput param1) {
         this.nickname = param1.readUTF();
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of IdentificationSuccessMessage.accountId.");
         }
    }

    private void _communityIdFunc(ICustomDataInput param1) {
         this.communityId = param1.readByte();
         if(this.communityId < 0)
         {
            throw new Exception("Forbidden value (" + this.communityId + ") on element of IdentificationSuccessMessage.communityId.");
         }
    }

    private void _secretQuestionFunc(ICustomDataInput param1) {
         this.secretQuestion = param1.readUTF();
    }

    private void _accountCreationFunc(ICustomDataInput param1) {
         this.accountCreation = param1.readDouble();
         if(this.accountCreation < 0 || this.accountCreation > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.accountCreation + ") on element of IdentificationSuccessMessage.accountCreation.");
         }
    }

    private void _subscriptionElapsedDurationFunc(ICustomDataInput param1) {
         this.subscriptionElapsedDuration = param1.readDouble();
         if(this.subscriptionElapsedDuration < 0 || this.subscriptionElapsedDuration > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionElapsedDuration + ") on element of IdentificationSuccessMessage.subscriptionElapsedDuration.");
         }
    }

    private void _subscriptionEndDateFunc(ICustomDataInput param1) {
         this.subscriptionEndDate = param1.readDouble();
         if(this.subscriptionEndDate < 0 || this.subscriptionEndDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionEndDate + ") on element of IdentificationSuccessMessage.subscriptionEndDate.");
         }
    }

    private void _havenbagAvailableRoomFunc(ICustomDataInput param1) {
         this.havenbagAvailableRoom = param1.readUnsignedByte();
         if(this.havenbagAvailableRoom < 0 || this.havenbagAvailableRoom > 255)
         {
            throw new Exception("Forbidden value (" + this.havenbagAvailableRoom + ") on element of IdentificationSuccessMessage.havenbagAvailableRoom.");
         }
    }

}