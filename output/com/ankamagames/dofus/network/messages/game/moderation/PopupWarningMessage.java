package com.ankamagames.dofus.network.messages.game.moderation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PopupWarningMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6134;
    private boolean _isInitialized = false;
    private int lockDuration = 0;
    private String author = "";
    private String content = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6134;
    }

    public PopupWarningMessage initPopupWarningMessage(int param1,String  param2,String  param3) {
         this.lockDuration = param1;
         this.author = param2;
         this.content = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.lockDuration = 0;
         this.author = "";
         this.content = "";
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
         this.serializeAs_PopupWarningMessage(param1);
    }

    public void serializeAs_PopupWarningMessage(ICustomDataOutput param1) {
         if(this.lockDuration < 0 || this.lockDuration > 255)
         {
            throw new Exception("Forbidden value (" + this.lockDuration + ") on element lockDuration.");
         }
         param1.writeByte(this.lockDuration);
         param1.writeUTF(this.author);
         param1.writeUTF(this.content);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PopupWarningMessage(param1);
    }

    public void deserializeAs_PopupWarningMessage(ICustomDataInput param1) {
         this._lockDurationFunc(param1);
         this._authorFunc(param1);
         this._contentFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PopupWarningMessage(param1);
    }

    public void deserializeAsyncAs_PopupWarningMessage(FuncTree param1) {
         param1.addChild(this._lockDurationFunc);
         param1.addChild(this._authorFunc);
         param1.addChild(this._contentFunc);
    }

    private void _lockDurationFunc(ICustomDataInput param1) {
         this.lockDuration = param1.readUnsignedByte();
         if(this.lockDuration < 0 || this.lockDuration > 255)
         {
            throw new Exception("Forbidden value (" + this.lockDuration + ") on element of PopupWarningMessage.lockDuration.");
         }
    }

    private void _authorFunc(ICustomDataInput param1) {
         this.author = param1.readUTF();
    }

    private void _contentFunc(ICustomDataInput param1) {
         this.content = param1.readUTF();
    }

}