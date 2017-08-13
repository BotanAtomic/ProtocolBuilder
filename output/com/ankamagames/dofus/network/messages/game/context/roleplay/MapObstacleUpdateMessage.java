package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.MapObstacle;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapObstacleUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6051;
    private boolean _isInitialized = false;
    private Vector<MapObstacle> obstacles;
    private FuncTree _obstaclestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6051;
    }

    public MapObstacleUpdateMessage initMapObstacleUpdateMessage(Vector<MapObstacle> param1) {
         this.obstacles = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.obstacles = new Vector.<MapObstacle>();
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
         this.serializeAs_MapObstacleUpdateMessage(param1);
    }

    public void serializeAs_MapObstacleUpdateMessage(ICustomDataOutput param1) {
         param1.writeShort(this.obstacles.length);
         int _loc2_ = 0;
         while(_loc2_ < this.obstacles.length)
         {
            (this.obstacles[_loc2_] as MapObstacle).serializeAs_MapObstacle(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapObstacleUpdateMessage(param1);
    }

    public void deserializeAs_MapObstacleUpdateMessage(ICustomDataInput param1) {
         MapObstacle _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new MapObstacle();
            _loc4_.deserialize(param1);
            this.obstacles.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapObstacleUpdateMessage(param1);
    }

    public void deserializeAsyncAs_MapObstacleUpdateMessage(FuncTree param1) {
         this._obstaclestree = param1.addChild(this._obstaclestreeFunc);
    }

    private void _obstaclestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._obstaclestree.addChild(this._obstaclesFunc);
            _loc3_++;
         }
    }

    private void _obstaclesFunc(ICustomDataInput param1) {
         MapObstacle _loc2_ = new MapObstacle();
         _loc2_.deserialize(param1);
         this.obstacles.push(_loc2_);
    }

}