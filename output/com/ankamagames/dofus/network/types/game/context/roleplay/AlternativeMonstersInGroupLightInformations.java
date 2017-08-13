package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlternativeMonstersInGroupLightInformations extends Object implements INetworkType {

    private int protocolId = 394;
    private int playerCount = 0;
    private Vector<MonsterInGroupLightInformations> monsters;
    private FuncTree _monsterstree;


    public int getTypeId() {
         return 394;
    }

    public AlternativeMonstersInGroupLightInformations initAlternativeMonstersInGroupLightInformations(int param1,Vector<MonsterInGroupLightInformations>  param2) {
         this.playerCount = param1;
         this.monsters = param2;
         return this;
    }

    public void reset() {
         this.playerCount = 0;
         this.monsters = new Vector.<MonsterInGroupLightInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AlternativeMonstersInGroupLightInformations(param1);
    }

    public void serializeAs_AlternativeMonstersInGroupLightInformations(ICustomDataOutput param1) {
         param1.writeInt(this.playerCount);
         param1.writeShort(this.monsters.length);
         int _loc2_ = 0;
         while(_loc2_ < this.monsters.length)
         {
            (this.monsters[_loc2_] as MonsterInGroupLightInformations).serializeAs_MonsterInGroupLightInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AlternativeMonstersInGroupLightInformations(param1);
    }

    public void deserializeAs_AlternativeMonstersInGroupLightInformations(ICustomDataInput param1) {
         MonsterInGroupLightInformations _loc4_ = null;
         this._playerCountFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new MonsterInGroupLightInformations();
            _loc4_.deserialize(param1);
            this.monsters.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AlternativeMonstersInGroupLightInformations(param1);
    }

    public void deserializeAsyncAs_AlternativeMonstersInGroupLightInformations(FuncTree param1) {
         param1.addChild(this._playerCountFunc);
         this._monsterstree = param1.addChild(this._monsterstreeFunc);
    }

    private void _playerCountFunc(ICustomDataInput param1) {
         this.playerCount = param1.readInt();
    }

    private void _monsterstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._monsterstree.addChild(this._monstersFunc);
            _loc3_++;
         }
    }

    private void _monstersFunc(ICustomDataInput param1) {
         MonsterInGroupLightInformations _loc2_ = new MonsterInGroupLightInformations();
         _loc2_.deserialize(param1);
         this.monsters.push(_loc2_);
    }

}