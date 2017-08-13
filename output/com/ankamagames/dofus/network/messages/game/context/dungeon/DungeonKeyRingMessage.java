package package com.ankamagames.dofus.network.messages.game.context.dungeon;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class DungeonKeyRingMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6299;
    private boolean _isInitialized = false;
    private Vector.<uint> availables = ;
    private Vector.<uint> unavailables = ;
    private FuncTree _availablestree = ;
    private FuncTree _unavailablestree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc7_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6299;
    }

    public DungeonKeyRingMessage initDungeonKeyRingMessage(Vector.<uint> param1,Vector.<uint>  param2) {
         this.availables = param1;
         this.unavailables = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.availables = new Vector.<uint>();
         this.unavailables = new Vector.<uint>();
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
         this.serializeAs_DungeonKeyRingMessage(param1);
    }

    public void serializeAs_DungeonKeyRingMessage(ICustomDataOutput param1) {
         param1.writeShort(this.availables.length);
         int _loc2_ = 0;
         while(_loc2_ < this.availables.length)
            if(this.availables[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.availables[_loc2_] + ") on element 1 (starting at 1) of availables.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DungeonKeyRingMessage(param1);
    }

    public void deserializeAs_DungeonKeyRingMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of availables.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DungeonKeyRingMessage(param1);
    }

    public void deserializeAsyncAs_DungeonKeyRingMessage(FuncTree param1) {
         this._availablestree = param1.addChild(this._availablestreeFunc);
         this._unavailablestree = param1.addChild(this._unavailablestreeFunc);
    }

    private void _availablestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._availablestree.addChild(this._availablesFunc);
            _loc3_++;
    }

    private void _availablesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of availables.");
    }

    private void _unavailablestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._unavailablestree.addChild(this._unavailablesFunc);
            _loc3_++;
    }

    private void _unavailablesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of unavailables.");
    }

}