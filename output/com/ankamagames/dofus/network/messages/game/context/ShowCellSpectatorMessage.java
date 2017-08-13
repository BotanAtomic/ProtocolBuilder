package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShowCellSpectatorMessage extends ShowCellMessage implements INetworkMessage {

    private int protocolId = 6158;
    private boolean _isInitialized = false;
    private String playerName = "";


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6158;
    }

    public ShowCellSpectatorMessage initShowCellSpectatorMessage(Number param1,int  param2,String  param3) {
         super.initShowCellMessage(param1,param2);
         this.playerName = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.playerName = "";
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
         this.serializeAs_ShowCellSpectatorMessage(param1);
    }

    public void serializeAs_ShowCellSpectatorMessage(ICustomDataOutput param1) {
         super.serializeAs_ShowCellMessage(param1);
         param1.writeUTF(this.playerName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShowCellSpectatorMessage(param1);
    }

    public void deserializeAs_ShowCellSpectatorMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._playerNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShowCellSpectatorMessage(param1);
    }

    public void deserializeAsyncAs_ShowCellSpectatorMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._playerNameFunc);
    }

    private void _playerNameFunc(ICustomDataInput param1) {
         this.playerName = param1.readUTF();
    }

}