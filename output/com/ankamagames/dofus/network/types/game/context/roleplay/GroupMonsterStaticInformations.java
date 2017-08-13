package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GroupMonsterStaticInformations extends Object implements INetworkType {

    private int protocolId = 140;
    private MonsterInGroupLightInformations mainCreatureLightInfos = ;
    private Vector.<MonsterInGroupInformations> underlings = ;
    private FuncTree _mainCreatureLightInfostree = ;
    private FuncTree _underlingstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 140;
    }

    public GroupMonsterStaticInformations initGroupMonsterStaticInformations(MonsterInGroupLightInformations param1,Vector.<MonsterInGroupInformations>  param2) {
         this.mainCreatureLightInfos = param1;
         this.underlings = param2;
         return this;
    }

    public void reset() {
         this.mainCreatureLightInfos = new MonsterInGroupLightInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GroupMonsterStaticInformations(param1);
    }

    public void serializeAs_GroupMonsterStaticInformations(ICustomDataOutput param1) {
         this.mainCreatureLightInfos.serializeAs_MonsterInGroupLightInformations(param1);
         param1.writeShort(this.underlings.length);
         int _loc2_ = 0;
         while(_loc2_ < this.underlings.length)
            (this.underlings[_loc2_] as MonsterInGroupInformations).serializeAs_MonsterInGroupInformations(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GroupMonsterStaticInformations(param1);
    }

    public void deserializeAs_GroupMonsterStaticInformations(ICustomDataInput param1) {
         MonsterInGroupInformations _loc4_ = null;
         this.mainCreatureLightInfos = new MonsterInGroupLightInformations();
         this.mainCreatureLightInfos.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new MonsterInGroupInformations();
            _loc4_.deserialize(param1);
            this.underlings.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GroupMonsterStaticInformations(param1);
    }

    public void deserializeAsyncAs_GroupMonsterStaticInformations(FuncTree param1) {
         this._mainCreatureLightInfostree = param1.addChild(this._mainCreatureLightInfostreeFunc);
         this._underlingstree = param1.addChild(this._underlingstreeFunc);
    }

    private void _mainCreatureLightInfostreeFunc(ICustomDataInput param1) {
         this.mainCreatureLightInfos = new MonsterInGroupLightInformations();
         this.mainCreatureLightInfos.deserializeAsync(this._mainCreatureLightInfostree);
    }

    private void _underlingstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._underlingstree.addChild(this._underlingsFunc);
            _loc3_++;
    }

    private void _underlingsFunc(ICustomDataInput param1) {
         MonsterInGroupInformations _loc2_ = new MonsterInGroupInformations();
         _loc2_.deserialize(param1);
         this.underlings.push(_loc2_);
    }

}