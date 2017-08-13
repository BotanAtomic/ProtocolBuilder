package package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChangeThemeRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6639;
    private boolean _isInitialized = false;
    private int theme = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6639;
    }

    public ChangeThemeRequestMessage initChangeThemeRequestMessage(int param1) {
         this.theme = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.theme = 0;
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
         this.serializeAs_ChangeThemeRequestMessage(param1);
    }

    public void serializeAs_ChangeThemeRequestMessage(ICustomDataOutput param1) {
         param1.writeByte(this.theme);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChangeThemeRequestMessage(param1);
    }

    public void deserializeAs_ChangeThemeRequestMessage(ICustomDataInput param1) {
         this._themeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChangeThemeRequestMessage(param1);
    }

    public void deserializeAsyncAs_ChangeThemeRequestMessage(FuncTree param1) {
         param1.addChild(this._themeFunc);
    }

    private void _themeFunc(ICustomDataInput param1) {
         this.theme = param1.readByte();
    }

}