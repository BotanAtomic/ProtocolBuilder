package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightOptionToggleMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 707;
    private boolean _isInitialized = false;
    private int option = 3;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 707;
    }

    public GameFightOptionToggleMessage initGameFightOptionToggleMessage(int param1) {
         this.option = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.option = 3;
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
         this.serializeAs_GameFightOptionToggleMessage(param1);
    }

    public void serializeAs_GameFightOptionToggleMessage(ICustomDataOutput param1) {
         param1.writeByte(this.option);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightOptionToggleMessage(param1);
    }

    public void deserializeAs_GameFightOptionToggleMessage(ICustomDataInput param1) {
         this._optionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightOptionToggleMessage(param1);
    }

    public void deserializeAsyncAs_GameFightOptionToggleMessage(FuncTree param1) {
         param1.addChild(this._optionFunc);
    }

    private void _optionFunc(ICustomDataInput param1) {
         this.option = param1.readByte();
         if(this.option < 0)
         {
            throw new Exception("Forbidden value (" + this.option + ") on element of GameFightOptionToggleMessage.option.");
         }
    }

}