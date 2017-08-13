package package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AuthenticationTicketMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 110;
    private boolean _isInitialized = false;
    private String lang = "";
    private String ticket = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 110;
    }

    public AuthenticationTicketMessage initAuthenticationTicketMessage(String param1,String  param2) {
         this.lang = param1;
         this.ticket = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.lang = "";
         this.ticket = "";
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
         this.serializeAs_AuthenticationTicketMessage(param1);
    }

    public void serializeAs_AuthenticationTicketMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.lang);
         param1.writeUTF(this.ticket);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AuthenticationTicketMessage(param1);
    }

    public void deserializeAs_AuthenticationTicketMessage(ICustomDataInput param1) {
         this._langFunc(param1);
         this._ticketFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AuthenticationTicketMessage(param1);
    }

    public void deserializeAsyncAs_AuthenticationTicketMessage(FuncTree param1) {
         param1.addChild(this._langFunc);
         param1.addChild(this._ticketFunc);
    }

    private void _langFunc(ICustomDataInput param1) {
         this.lang = param1.readUTF();
    }

    private void _ticketFunc(ICustomDataInput param1) {
         this.ticket = param1.readUTF();
    }

}