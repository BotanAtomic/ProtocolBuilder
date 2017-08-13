package com.ankamagames.dofus.network.messages.game.approach;

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

public class AccountCapabilitiesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6216;
    private boolean _isInitialized = false;
    private int accountId = 0;
    private boolean tutorialAvailable = false;
    private int breedsVisible = 0;
    private int breedsAvailable = 0;
    private int status = -1;
    private boolean canCreateNewCharacter = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6216;
    }

    public AccountCapabilitiesMessage initAccountCapabilitiesMessage(int param1,boolean  param2,int  param3,int  param4,int  param5,boolean  param6) {
         this.accountId = param1;
         this.tutorialAvailable = param2;
         this.breedsVisible = param3;
         this.breedsAvailable = param4;
         this.status = param5;
         this.canCreateNewCharacter = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.accountId = 0;
         this.tutorialAvailable = false;
         this.breedsVisible = 0;
         this.breedsAvailable = 0;
         this.status = -1;
         this.canCreateNewCharacter = false;
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
         this.serializeAs_AccountCapabilitiesMessage(param1);
    }

    public void serializeAs_AccountCapabilitiesMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.tutorialAvailable);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.canCreateNewCharacter);
         param1.writeByte(_loc2_);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         if(this.breedsVisible < 0)
         {
            throw new Exception("Forbidden value (" + this.breedsVisible + ") on element breedsVisible.");
         }
         param1.writeVarInt(this.breedsVisible);
         if(this.breedsAvailable < 0)
         {
            throw new Exception("Forbidden value (" + this.breedsAvailable + ") on element breedsAvailable.");
         }
         param1.writeVarInt(this.breedsAvailable);
         param1.writeByte(this.status);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AccountCapabilitiesMessage(param1);
    }

    public void deserializeAs_AccountCapabilitiesMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._accountIdFunc(param1);
         this._breedsVisibleFunc(param1);
         this._breedsAvailableFunc(param1);
         this._statusFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AccountCapabilitiesMessage(param1);
    }

    public void deserializeAsyncAs_AccountCapabilitiesMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._accountIdFunc);
         param1.addChild(this._breedsVisibleFunc);
         param1.addChild(this._breedsAvailableFunc);
         param1.addChild(this._statusFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.tutorialAvailable = BooleanByteWrapper.getFlag(_loc2_,0);
         this.canCreateNewCharacter = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of AccountCapabilitiesMessage.accountId.");
         }
    }

    private void _breedsVisibleFunc(ICustomDataInput param1) {
         this.breedsVisible = param1.readVarUhInt();
         if(this.breedsVisible < 0)
         {
            throw new Exception("Forbidden value (" + this.breedsVisible + ") on element of AccountCapabilitiesMessage.breedsVisible.");
         }
    }

    private void _breedsAvailableFunc(ICustomDataInput param1) {
         this.breedsAvailable = param1.readVarUhInt();
         if(this.breedsAvailable < 0)
         {
            throw new Exception("Forbidden value (" + this.breedsAvailable + ") on element of AccountCapabilitiesMessage.breedsAvailable.");
         }
    }

    private void _statusFunc(ICustomDataInput param1) {
         this.status = param1.readByte();
    }

}