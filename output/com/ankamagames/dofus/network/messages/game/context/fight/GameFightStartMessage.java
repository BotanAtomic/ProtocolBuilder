package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightStartMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 712;
    private boolean _isInitialized = false;
    private Vector.<Idol> idols = ;
    private FuncTree _idolstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 712;
    }

    public GameFightStartMessage initGameFightStartMessage(Vector.<Idol> param1) {
         this.idols = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.idols = new Vector.<Idol>();
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
         this.serializeAs_GameFightStartMessage(param1);
    }

    public void serializeAs_GameFightStartMessage(ICustomDataOutput param1) {
         param1.writeShort(this.idols.length);
         int _loc2_ = 0;
         while(_loc2_ < this.idols.length)
            (this.idols[_loc2_] as Idol).serializeAs_Idol(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightStartMessage(param1);
    }

    public void deserializeAs_GameFightStartMessage(ICustomDataInput param1) {
         Idol _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new Idol();
            _loc4_.deserialize(param1);
            this.idols.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightStartMessage(param1);
    }

    public void deserializeAsyncAs_GameFightStartMessage(FuncTree param1) {
         this._idolstree = param1.addChild(this._idolstreeFunc);
    }

    private void _idolstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._idolstree.addChild(this._idolsFunc);
            _loc3_++;
    }

    private void _idolsFunc(ICustomDataInput param1) {
         Idol _loc2_ = new Idol();
         _loc2_.deserialize(param1);
         this.idols.push(_loc2_);
    }

}