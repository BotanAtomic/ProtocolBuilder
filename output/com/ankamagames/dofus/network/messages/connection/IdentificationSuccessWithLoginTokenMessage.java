package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationSuccessWithLoginTokenMessage extends IdentificationSuccessMessage implements INetworkMessage {

    private int protocolId = 6209;
    private boolean _isInitialized = false;
    private String loginToken = "";


    public void serialize(ICustomDataOutput param1) {
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
         param1.writeUTF(this.loginToken);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.hasRights = BooleanByteWrapper.getFlag(_loc2_,0);
         this.wasAlreadyConnected = BooleanByteWrapper.getFlag(_loc2_,1);
         this.login = param1.readUTF();
         this.nickname = param1.readUTF();
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of IdentificationSuccessMessage.accountId.");
         }
         this.communityId = param1.readByte();
         if(this.communityId < 0)
         {
            throw new Exception("Forbidden value (" + this.communityId + ") on element of IdentificationSuccessMessage.communityId.");
         }
         this.secretQuestion = param1.readUTF();
         this.accountCreation = param1.readDouble();
         if(this.accountCreation < 0 || this.accountCreation > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.accountCreation + ") on element of IdentificationSuccessMessage.accountCreation.");
         }
         this.subscriptionElapsedDuration = param1.readDouble();
         if(this.subscriptionElapsedDuration < 0 || this.subscriptionElapsedDuration > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionElapsedDuration + ") on element of IdentificationSuccessMessage.subscriptionElapsedDuration.");
         }
         this.subscriptionEndDate = param1.readDouble();
         if(this.subscriptionEndDate < 0 || this.subscriptionEndDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.subscriptionEndDate + ") on element of IdentificationSuccessMessage.subscriptionEndDate.");
         }
         this.havenbagAvailableRoom = param1.readUnsignedByte();
         if(this.havenbagAvailableRoom < 0 || this.havenbagAvailableRoom > 255)
         {
            throw new Exception("Forbidden value (" + this.havenbagAvailableRoom + ") on element of IdentificationSuccessMessage.havenbagAvailableRoom.");
         }
         this.loginToken = param1.readUTF();
    }

}